#! /bin/bash
##############################
# Packages required:  dialog #
##############################

##############################
dir=$(pwd)
##############################

CHECK=`which dialog`
[ ! $CHECK = /usr/bin/dialog ] && sudo apt install -y dialog
echo -e "" 
rm -f build/bitbake.lock
clear
## Menu Select Boxes ##
BOX_1="dm500hdv2"
BOX_2="dm800sev2"
BOX_3="dm520"
BOX_4="dm820"
BOX_5="dm7020hd"
BOX_6="dm7080"
BOX_7="dm8000"
BOX_8="dm900"
BOX_9="dm920"
BOX_10="dreamone"
BOX_11="dreamtwo"
list=
for i in $(seq 1 11); do
    p="BOX_$i"
    list="$list $i ${!p} "
done
list=($list)
box=$(dialog --stdout --clear --colors --backtitle "Build Image" --menu "Select Boxes" 18 40 10 ${list[@]})
    case $box in
    1)
    echo "($box) Select DM500hdv2"
    ;;
    2)
    echo "($box) Select DM800sev2"
    ;;
    3)
    echo "($box) Select DM520"
    ;;
    4)
    echo "($box) Select DM820"
    ;;
    5)
    echo "($box) Select DM7020HD"
    ;;
    6)
    echo "($box) Select DM7080"
    ;;
    7)
    echo "($box) Select DM8000"
    ;;
    8)
    echo "($box) Select DM900"
    ;;
    9)
    echo "($box) Select DM920"
    ;;
    10)
    echo "($box) Select DreamOne"
    ;;
    11)
    echo "($box) Select DreamTwo"
    ;;
    *) clear && exit ;;
    esac
v="BOX_$box"
Device=${!v}

clear

## Menu Select build type ##
TYPE_1="image"
TYPE_2="feed"
list=
for i in $(seq 1 2); do
    p="TYPE_$i"
    list="$list $i ${!p} "
done
list=($list)
build=$(dialog --stdout --clear --colors --backtitle "Build Image" --menu "Select build type (${Device})" 12 40 10 ${list[@]})
    case $build in
    1)
    echo "($build) Select image"
    ;;
    2)
    echo "($build) Select feed"
    ;;
    *) clear && exit ;;
    esac
t="TYPE_$build"
TYPE=${!t}

clear

make update && MACHINE=${Device} make ${TYPE}

exit 0
