# Depend on Python 3

Build environment for (DM800se, DM500HD, DM800seV2, DM500HDV2, DM520/525, DM820, DM7080 and DM900/920 ... DreamOne/Two not ready yet (Audio issue))

Based on OpenPLi, also derived from Hains source.<br>

 ***************************************************************************************************************************
# WARRNING : The compile images for DM800se and DM500HD to External flash only For [Multiboot]. Because it is more than 64MB
 ***************************************************************************************************************************

Thanks to OpenPLi, Open-Alliance and Hains.

https://github.com/OpenPLi/openpli-oe-core<br>
https://github.com/Hains/openpli-dm920-python3<br>
https://github.com/oe-alliance/oe-alliance-core


-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of September 3, 2023.<br>
-GCC 13.2.0 <br>
-Glibc 2.38<br>
-GStreamer 1.22.5<br>
-Python 3.11.5<br>
-OpenSSL 3.1.2<br>
-Busybox 1.36.1<br>
and more.<br>
<br>
<br>
Feel free to send pull-request.

Tested with Ubuntu 23.04.
<br>
<br>
# Dependencies:
1. Install required packages
```
sudo apt install -y autoconf automake bison bzip2 cvs diffstat flex g++ g++-multilib gawk gcc gettext git git-lfs gzip help2man ncurses-bin libncurses5-dev libc6-dev libtool lz4 liblz4-tool make texinfo patch perl pkg-config subversion tar texi2html wget chrpath libxml2-utils xsltproc python3-setuptools libc6 genromfs mtd-utils dpkg-dev sshpass poedit translate-toolkit xclip linux-firmware linux-headers-`uname -r` linux-headers-`uname -r` linux-image-`uname -r` linux-tools-`uname -r` linux-libc-dev linux-source u-boot-tools upx-ucl doxygen optipng libglib2.0-dev pngquant default-jdk fastboot adb libssl-dev libc6-dev-i386 lib32z1 m4 intltool ccache zlib1g zlib1g-dev liblzo2-dev tcl dpkg asciidoc texlive-latex-base dblatex xutils-dev gparted openssh-server nfs-common nfs-kernel-server lintian git-doc git-gui gitk indent tofrodos fakeroot meld atftpd sharutils manpages-dev manpages-posix manpages-posix-dev libgdk-pixbuf2.0-dev linux-doc build-essential socat libsdl1.2-dev xterm gcc-multilib libopenmpi-dev parted mercurial binutils imagemagick librsvg2-bin jq linux-headers-generic python3-pip python3-autopep8 python3-six python3-six libnl-3-dev libimage-exiftool-perl dos2unix ffmpeg dialog default-jre libc6-i386 quilt zstd lib32tinfo6 guile-2.2-libs lib32ncurses6 lib32ncursesw6 lib32ncurses-dev
```
2. Set your shell to `/bin/bash`
```sh
sudo dpkg-reconfigure dash
↳ Select "NO" when asked "Install dash as /bin/sh?"
```
# To build image:
```
git clone https://github.com/fairbird/openpli-dreambox-oe-core.git

cd openpli-dreambox-oe-core

./build_image.sh
```
![Selection_001](https://user-images.githubusercontent.com/1761779/130413731-c24a2ddd-ca71-437e-8734-bdfc2f8729ff.png)

![Selection_002](https://user-images.githubusercontent.com/1761779/130413735-8f2a0caf-e3f7-4264-b33e-b474ac13d245.png)

When the build is finished, the image openpli-enigma2-GCC-12.2-(box-name).rootfs.tar.(xz_or_bz2_or_zip) is in the:
```
build/tmp/deploy/images/<box name>/
```
directory.

# To upload feed:

Install apache2:
```
sudo apt install apache2
```
Create symlinks to your build-environment:
```
cd /var/www/html

sudo mkdir feeds;cd feeds;sudo mkdir openpli-Dreambox;cd openpli-Dreambox;

sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/<box name> <box name> 

sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/cortexa15hf-neon-vfpv4 cortexa15hf-neon-vfpv4
  
sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/mips32el mips32el
```
Add hostname or ip address to the site.conf file (exist after make command), e.g. at the end of the file.
```
DISTRO_HOST = " <your ip address or hostname> "
```
To update the image or feed, run:
```
./build_image.sh
```
==========================================================
