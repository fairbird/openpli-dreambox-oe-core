# Depend on Python 3

Build environment for (DM800se, DM500HD, DM800seV2, DM500HDV2, DM520/525, DM820, DM7080 and DM900/920 ... DreamOne/Two not ready yet (Audio issue))

Based on OpenPLi, also derived from Hains source.<br>

 ***************************************************************************************************************************
# WARRNING : The compile images for DM800se and DM500HD to External flash only For [Multiboot]. Because it is more than 64MB
 ***************************************************************************************************************************

Thanks to OpenPLi, openATV, Open-Alliance and Hains.

https://github.com/OpenPLi/openpli-oe-core<br>
https://github.com/openatv/enigma2<br>
https://github.com/Hains/openpli-dm920-python3<br>
https://github.com/oe-alliance/oe-alliance-core


-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of October 18, 2025.<br>
-GCC 15.2.0<br>
-Glibc 2.42<br>
-ffmpeg 8.0<br>
-GStreamer 1.26.7<br>
-Python 3.13.9<br>
-OpenSSL 3.5.2<br>
-Busybox 1.37.0<br>
and more.<br>
<br>
<br>
Feel free to send pull-request.
<br>
<br>

# Note Ubuntu: Due to new security features:

See:
https://ubuntu.com/blog/whats-new-in-security-for-ubuntu-24-04-lts

Modify AppArmor config file with the following contents to fix error (Operation not permitted):
```
echo 'kernel.apparmor_restrict_unprivileged_userns=0' | sudo tee /etc/sysctl.d/60-apparmor-namespace.conf > /dev/null && sudo sysctl --system

sudo sysctl -w kernel.apparmor_restrict_unprivileged_userns=0
```

# Note for Ubuntu 25.10.<br>
Use coreutils instead of rust-coreutils.<br>
https://bugzilla.yoctoproject.org/show_bug.cgi?id=16028<br>
https://discourse.ubuntu.com/t/migration-to-rust-coreutils-in-25-10/59708

```
sudo apt install coreutils-from-gnu coreutils-from-uutils- --allow-remove-essential
```
# Note: Solution for compile/build nodejs problem:
https://github.com/fairbird/openpli-dreambox-oe-core/issues/116#event-18499432564

# Dependencies:
1. Install required packages
```
sudo apt-get install -y autoconf automake bison bzip2 chrpath cmake coreutils cpio curl cvs debianutils default-jre default-jre-headless diffstat flex g++ gawk gcc gcc-12 gcc-multilib g++-multilib gettext git git-lfs gzip help2man info iputils-ping java-common libc6-dev libc6-dev-i386 libglib2.0-dev libncurses-dev libperl4-corelibs-perl libproc-processtable-perl libsdl1.2-dev libserf-dev libtool libxml2-utils make ncurses-bin patch perl pkg-config psmisc python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-setuptools quilt socat sshpass subversion tar texi2html texinfo unzip wget xsltproc xterm xz-utils zip zlib1g-dev zstd fakeroot lz4 lib32ncurses-dev genromfs guile-2.2-libs dialog php-cli
```
2. Set your shell to `/bin/bash`
```
sudo ln -sf /bin/bash /bin/sh
```
3. Set python3 as preferred provider for python
```
sudo update-alternatives --install /usr/bin/python python /usr/bin/python2 1

sudo update-alternatives --install /usr/bin/python python /usr/bin/python3 2

sudo update-alternatives --config python
↳ Select python3
```
# To build image:
Clone the source (only one time) ...
```
git clone https://github.com/fairbird/openpli-dreambox-oe-core.git
```
Then every time need to build image ...
```
cd openpli-dreambox-oe-core

./build_image.sh
```
![Selection_001](https://user-images.githubusercontent.com/1761779/130413731-c24a2ddd-ca71-437e-8734-bdfc2f8729ff.png)

![Selection_002](https://user-images.githubusercontent.com/1761779/130413735-8f2a0caf-e3f7-4264-b33e-b474ac13d245.png)

When the build is finished, the image openpli-enigma2-GCC-x.x-(box-name).rootfs.tar.(xz_or_bz2_or_zip) is located in the:
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
With recent Apache2, fix file permission problem with symlinks:
```
sudo chown -Rf <username> openpli-dm920-python3/build/tmp/deploy/ipk
```
<br>Add hostname or ip address to the site.conf file (file exist after make command), e.g. at the end of the file.
```
DISTRO_HOST = " <your ip address or hostname> "
```
<br>To update the image or feed, run:
```
./build_image.sh
```
==========================================================

