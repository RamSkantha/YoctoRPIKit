obj-m += hello.o
all:
	make -C $(KERNEL_SRC) M=$(PWD) modules
install:
	@echo ">>> USING CORRECT MAKEFILE <<<"
	make -C $(KERNEL_SRC) M=$(PWD) modules_install
clean:
	make -C $(KERNEL_SRC) M=$(PWD) clean
