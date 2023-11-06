FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-gasket-patch.patch \
			file://0002-DTS-changes.patch \
			file://gasket.cfg"

do_configure:append() {
	cat ../*.cfg >> ${B}/.config
}
