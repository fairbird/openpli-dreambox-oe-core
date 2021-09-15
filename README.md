Build environment for (DM800se, DM500HD, DM800seV2, DM500HDV2, DM520/525, DM820, DM7080 and DM900/920 ... DreamOne/Two not ready yet (Audio issue)) based on OpenPLi, also derived from openvision (closed source).<br>

Warrning: The compile images for DM800se and DM500HD to External flash only, For [Multiboot]

Thanks to OpenPLi and Open-Alliance.

https://github.com/OpenPLi/openpli-oe-core<br>
https://github.com/oe-alliance/oe-alliance-core/commits/5.0

-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of July 3, 2021.<br>
-GCC 11.1.1 (11.1.0 patched upstream) <br>
-Glibc 2.33<br>
-GStreamer 1.19.1.1<br>
-Python 2.7.18<br>
-OpenSSL 1.1.1k<br>
-Busybox 1.33.1<br>
and more.<br>
<br>
<br>
Feel free to send pull-request.

Tested with Ubuntu 21.04.
<br>
<br>
Dependencies:
```
sudo apt install autoconf automake bison bzip2 cvs default-jre diffstat flex g++ gawk gcc gettext git git-lfs gzip help2man ncurses-bin lib32ncurses5-dev libc6-dev libtool make texinfo patch perl pkg-config subversion tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386 genromfs guile-2.0-libs quilt dialog
```
To build image:
```
git clone https://github.com/fairbird/openpli-dreambox-oe-core.git

cd openpli-dreambox-oe-core

./build_image.sh
```
![Selection_001](https://user-images.githubusercontent.com/1761779/130413731-c24a2ddd-ca71-437e-8734-bdfc2f8729ff.png)

![Selection_002](https://user-images.githubusercontent.com/1761779/130413735-8f2a0caf-e3f7-4264-b33e-b474ac13d245.png)

When the build is finished, the image openpli-enigma2-GCC-11.1-<box name>.rootfs.tar.bz2 is in the:
```
build/tmp/deploy/images/<box name>/
```
directory.

To upload feed:

Install apache2:
```
sudo apt install apache2
```
Create symlinks to your build-environment:
```
cd /var/www/html

sudo mkdir feeds;cd feeds;sudo mkdir openpli-11.1;cd openpli-11.1;

sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/<box name> <box name> 

sudo ln -s /home/<your username>/openpli-dreambox-oe-core/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openpli-ddreambox-oe-core/build/tmp/deploy/ipk/cortexa15hf-neon-vfpv4 cortexa15hf-neon-vfpv4
  
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

Notice: 
* Run 'make feed' twice before you update the box!

==========================================================
