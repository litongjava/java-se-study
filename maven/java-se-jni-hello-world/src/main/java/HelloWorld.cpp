#include <jni.h>
#include "com_litongjava_HelloWorld.h"
#include <iostream>

JNIEXPORT void JNICALL Java_com_litongjava_HelloWorld_print(JNIEnv *, jobject) {
    std::cout << "Hello from C++!" << std::endl;
}