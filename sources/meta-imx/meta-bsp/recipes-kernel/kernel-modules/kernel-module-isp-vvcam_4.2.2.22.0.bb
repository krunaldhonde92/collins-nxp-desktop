# Copyright 2020-2023 NXP

DESCRIPTION = "Kernel loadable module for ISP"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${S}/../LICENSE;md5=64381a6ea83b48c39fe524c85f65fb44"

SRC_URI = "${ISP_KERNEL_SRC};branch=${SRCBRANCH}"
ISP_KERNEL_SRC ?= "git://github.com/nxp-imx/isp-vvcam.git;protocol=https"
SRCBRANCH = "lf-6.1.22_2.0.0"
SRCREV = "dad0b927a26100ebcfbcb6ad09d64ecde767af7f"

S = "${WORKDIR}/git/vvcam/v4l2"

inherit module

PARALLEL_MAKE = ""

DEBUG_PREFIX_MAP:prepend = " \
    -fmacro-prefix-map=${WORKDIR}/git/vvcam=/usr/src/debug/${PN}/${EXTENDPE}${PV}-${PR} \
    -fdebug-prefix-map=${WORKDIR}/git/vvcam=/usr/src/debug/${PN}/${EXTENDPE}${PV}-${PR} "

COMPATIBLE_MACHINE = "(mx8mp-nxp-bsp)"
