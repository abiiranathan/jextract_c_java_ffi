# Compiler settings
CC = gcc
JAVAC = javac
JAVA = java
JEXTRACT = jextract/bin/jextract

# Flags
CFLAGS = -fPIC -O3
LDFLAGS = -shared

# Directories
SRC_DIR = src
LIB_NAME = math
JAVA_PACKAGE = org.example

# Files
C_SOURCE = math.c
C_HEADER = math.h
JAVA_MAIN = MathLibTest.java
SHARED_LIB = lib$(LIB_NAME).so

# Update the java.library.path to include the current directory
export LD_LIBRARY_PATH := $(shell pwd):$(LD_LIBRARY_PATH)

# Targets
all: $(SHARED_LIB) java_bindings java_compile

$(SHARED_LIB): $(C_SOURCE) $(C_HEADER)
	$(CC) $(CFLAGS) -c $(C_SOURCE)
	$(CC) $(LDFLAGS) -o $@ math.o

java_bindings: $(C_HEADER) $(SHARED_LIB)
	$(JEXTRACT) --output $(SRC_DIR) -t $(JAVA_PACKAGE) -I. $(C_HEADER) --library $(LIB_NAME)

java_compile: java_bindings $(JAVA_MAIN)
	$(JAVAC) -sourcepath src  $(JAVA_MAIN)

run: all
	$(JAVA) --enable-native-access=ALL-UNNAMED -cp .:$(SRC_DIR) MathLibTest

clean:
	rm -f *.o $(SHARED_LIB) *.class *.so
	rm -rf $(SRC_DIR)

.PHONY: all java_bindings java_compile run clean