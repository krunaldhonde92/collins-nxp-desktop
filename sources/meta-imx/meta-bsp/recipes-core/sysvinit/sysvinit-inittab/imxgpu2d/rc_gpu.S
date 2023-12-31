#!/bin/bash
CPUREV=$(cat /sys/devices/soc0/soc_id)
FILEVG=/usr/lib/libOpenVG.so
FILEVGLIB=/usr/lib/libOpenVG.so.1
FILEVG3D=/usr/lib/libOpenVG.3d.so.1.1.0
FILEVG355=/usr/lib/libOpenVG.2d.so.1.1.0

if  [ -e $FILEVG3D ] && [ -e $FILEVG355 ]
then
  if [ -e  $FILEVG ]
  then
        rm -f $FILEVG
  fi
  if [ -e  $FILEVGLIB ]
  then
        rm -f $FILEVGLIB
  fi

  if [ $CPUREV == "i.MX6QP" ] || [ $CPUREV == "i.MX6Q" ] || [ $CPUREV == "i.MX6SL" ]
  then
        # Use GC355 VG
        ln -s $FILEVG355 $FILEVG
        ln -s $FILEVG355 $FILEVGLIB
  else
        ln -s $FILEVG3D $FILEVG
        ln -s $FILEVG3D $FILEVGLIB
  fi
fi
