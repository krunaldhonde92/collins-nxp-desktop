# xen 4.16.3 release sha
SRCREV ?= "556c2e817c9cf23b675eb4eaa2dc091f7bb3039f"

XEN_REL ?= "4.16"
XEN_BRANCH ?= "stable-${XEN_REL}"

SRC_URI = " \
    git://xenbits.xen.org/xen.git;branch=${XEN_BRANCH} \
    file://0001-python-pygrub-pass-DISTUTILS-xen-4.15.patch \
    file://0001-tools-xenstore-xenstored_control.c-correctly-print-t.patch \
    "

LIC_FILES_CHKSUM ?= "file://COPYING;md5=419739e325a50f3d7b4501338e44a4e5"

PV = "${XEN_REL}+stable${SRCPV}"

S = "${WORKDIR}/git"

require xen.inc
require xen-tools.inc

SYSTEMD_SERVICE:${PN}-xencommons:append = " \
    var-lib-xenstored.mount \
    "
