# Copyright 2019-21 NXP

SUMMARY = "NXP i.MX SECO library"
DESCRIPTION = "NXP IMX SECO library"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://EULA.txt;md5=85d06b38f17b935ca11784d67075b846"

DEPENDS = "zlib"

SRCBRANCH = "imx_5.4.70_2.3.4"
SECO_LIB_SRC ?= "git://github.com/NXP/imx-seco-libs.git;protocol=https"
SRC_URI = "${SECO_LIB_SRC};branch=${SRCBRANCH} \
        file://0001-Makefile-Fix-LIBDIR-for-multilib.patch \
        file://0002-Makefile-Fix-install-to-clear-host-user-contaminated.patch \
        file://0001-add-v2x_test-to-the-installed-binaries.patch \
"
SRCREV = "78d7375850208e8f6e7de7cd8b44f4f09015a5ed"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
	oe_runmake DESTDIR=${D} install
	chown -R root:root "${D}"
}

COMPATIBLE_MACHINE = "(mx8)"
COMPATIBLE_MACHINE_mx8m = "(^$)"
