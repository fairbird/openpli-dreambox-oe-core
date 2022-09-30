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
rm -f build/bitbake.sock
clear
## Menu Select Boxes ##
BOX_1="dm500hd"
BOX_2="dm500hdv2"
BOX_3="dm800se"
BOX_4="dm800sev2"
BOX_5="dm520"
BOX_6="dm820"
BOX_7="dm7020hd"
BOX_8="dm7020hdv2"
BOX_9="dm7080"
BOX_10="dm8000"
BOX_11="dm900"
BOX_12="dm920"
BOX_13="dreamone"
BOX_14="dreamtwo"
list=
for i in $(seq 1 14); do
    p="BOX_$i"
    list="$list $i ${!p} "
done
list=($list) #00ff2525
box=$(dialog --stdout --clear --colors --backtitle "Build Image" --menu "DM500hd/DM800se Images to External flash only, For [Multiboot]" 22 70 10 ${list[@]})
    case $box in
    1)
    echo "($box) Select DM500HD"
    ;;
    2)
    echo "($box) Select DM500HDv2"
    ;;
    3)
    echo "($box) Select DM800se"
    ;;
    4)
    echo "($box) Select DM800sev2"
    ;;
    5)
    echo "($box) Select DM520"
    ;;
    6)
    echo "($box) Select DM820"
    ;;
    7)
    echo "($box) Select DM7020HD"
    ;;
    8)
    echo "($box) Select dm7020hdv2"
    ;;
    9)
    echo "($box) Select DM7080"
    ;;
    10)
    echo "($box) Select DM8000"
    ;;
    11)
    echo "($box) Select DM900"
    ;;
    12)
    echo "($box) Select DM920"
    ;;
    13)
    echo "($box) Select DreamOne"
    ;;
    14)
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
build=$(dialog --stdout --clear --colors --backtitle "Build Image" --menu "Select build type (${Device})" 12 60 10 ${list[@]})
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
