#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include "Clear.h"

JNIEXPORT void JNICALL Java_Clear_cls
(JNIEnv * env, jobject obj) {

	system("cls");
	return;

}