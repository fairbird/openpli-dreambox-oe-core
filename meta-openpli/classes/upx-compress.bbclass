DEPENDS += " upx-native"
do_upx() {
	if [ ${FLASHSIZE} -le ${COMPRESS_UPTO} ]
	then
		echo "UPX - Binary compression"
		if [ "${TARGET_ARCH}" == "arm" ]
		then
			echo "Sorry UPX doesn't work reliably on arm.."
			echo "So no compression for your platform."
		else
			find "${UNPACKDIR}/packages-split" -type f -executable | while read line
			do
				if echo "${line}" | grep -q '/\.debug/'
				then
					echo "Skipping debug binary: ${line}"
				else
					if [ "`file -b "${line}" | cut -d, -f1`" == "ELF 32-bit LSB executable" ]
					then
						echo "Let's try and compress: ${line}"
						upx --best --ultra-brute "${line}" || true
					fi
				fi
			done
		fi
	fi
}
addtask upx before do_package_write_ipk after do_package_qa
