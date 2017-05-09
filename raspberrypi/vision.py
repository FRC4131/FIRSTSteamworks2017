import itertools, socket, time
import cv2
from grip import GripPipeline


stream = None
pipeline = GripPipeline()
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
while True:
	if not stream: stream = cv2.VideoCapture('http://roborio-4131-frc.local:1181/stream.mjpg')
	connected, frame = stream.read()
	if not connected:
		print('Camera down')
		time.sleep(1)
		stream.release()
		stream = None
		continue
	pipeline.process(frame)
	contours = pipeline.filter_contours_output
	has_target = bool(contours)
	tx = 0
	ty = 0
	if has_target:
		x, y, w, h = cv2.boundingRect(contours[0])
		tx = (x + w/2) * 4 #Counteract scaling
		ty = (y + h/2) * 4
	msg = ('%s %s %s' % (has_target, str(tx).zfill(3), str(ty).zfill(3))).encode('utf-8')
	sock.sendto(msg, ('roborio-4131-frc.local', 5800))
