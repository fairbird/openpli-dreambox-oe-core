#!/bin/sh
if [ ! -e /etc/.fixed ]
then
	rm -f /dev/null
	mknod /dev/null c 1 3
	touch /etc/.fixed
	sync
fi
exit 0
