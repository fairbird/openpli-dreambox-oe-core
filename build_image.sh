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
BOX_2="dm520"
BOX_3="dm820"
BOX_4="dm7020hd"
BOX_5="dm7080"
BOX_6="dm8000"
BOX_7="dm900"
BOX_8="dm920"
BOX_9="dreamone"
BOX_10="dreamtwo"
list=
for i in $(seq 1 10); do
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
    echo "($box) Select DM520"
    ;;
    3)
    echo "($box) Select DM820"
    ;;
    4)
    echo "($box) Select DM7020HD"
    ;;
    5)
    echo "($box) Select DM7080"
    ;;
    6)
    echo "($box) Select DM8000"
    ;;
    7)
    echo "($box) Select DM900"
    ;;
    8)
    echo "($box) Select DM920"
    ;;
    9)
    echo "($box) Select DreamOne"
    ;;
    10)
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
