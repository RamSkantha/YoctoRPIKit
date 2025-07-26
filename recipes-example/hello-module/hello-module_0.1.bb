DESCRIPTION = "Simple Hello Kernel Module"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"
inherit module
SRC_URI = "file://hello.c \
	   file://Makefile"

S = "${WORKDIR}"

KERNEL_MODULE_AUTOLOAD += "hello"

do_install() {
    echo ">>> USING CORRECT MAKEFILE <<<"
    install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
    make -C ${STAGING_KERNEL_DIR} M=${S} \
        INSTALL_MOD_PATH=${D} \
        INSTALL_MOD_DIR=extra \
        modules_install
}
