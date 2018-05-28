/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tools.build.jetifier.core.pom

/**
 * Map that provides extra configuration for versions of dependencies generated by Jetifier.
 */
data class DependencyVersionsMap(
        val oldSlVersion: String = "",
        val oldMaterialVersion: String = "",
        val oldRoomVersion: String = "",
        val newSlVersion: String = "",
        val newMaterialVersion: String = "",
        val newArchCoreVersion: String = "",
        val newLifecycleVersion: String = "",
        val newPagingVersion: String = "",
        val newRoomVersion: String = "",
        val newEspressoVersion: String = "",
        val newTestsVersion: String = "",
        val newJankTestHelperVersion: String = "",
        val newUiAutomatorVersion: String = ""
    ) {

    companion object {

        val LATEST = DependencyVersionsMap(
            oldSlVersion = "28.0.0",
            oldMaterialVersion = "28.0.0-alpha1",
            oldRoomVersion = "1.1.0",
            newSlVersion="1.0.0",
            newMaterialVersion = "1.0.0-alpha1",
            newArchCoreVersion = "2.0.0",
            newLifecycleVersion = "2.0.0",
            newPagingVersion = "2.0.0",
            newRoomVersion = "2.0.0",
            newEspressoVersion = "3.1.0-alpha1",
            newTestsVersion = "1.1.0-alpha1",
            newJankTestHelperVersion = "1.0.1-alpha1",
            newUiAutomatorVersion = "2.2.0-alpha1"
        )

        val ALPHA1 = DependencyVersionsMap(
            oldSlVersion = "28.0.0-alpha1",
            oldMaterialVersion = "28.0.0-alpha1",
            oldRoomVersion = "1.1.0",
            newSlVersion="1.0.0-alpha1",
            newMaterialVersion = "1.0.0-alpha1",
            newArchCoreVersion = "2.0.0-alpha1",
            newLifecycleVersion = "2.0.0-alpha1",
            newPagingVersion = "2.0.0-alpha1",
            newRoomVersion = "2.0.0-alpha1",
            newEspressoVersion = "3.1.0-alpha1",
            newTestsVersion = "1.1.0-alpha1",
            newJankTestHelperVersion = "1.0.1-alpha1",
            newUiAutomatorVersion = "2.2.0-alpha1"
        )

        val LATEST_RELEASED = ALPHA1

        fun parseFromVersionSetTypeId(versionSetType: String?): DependencyVersionsMap {
            versionSetType ?: return DependencyVersionsMap.LATEST

            return when (versionSetType) {
                "alpha1" -> DependencyVersionsMap.ALPHA1
                "latest" -> DependencyVersionsMap.LATEST
                else -> throw IllegalArgumentException(
                    "Version set type contains unsupported version set '$versionSetType'")
            }
        }
    }

    /** Takes a version from a configuration file and rewrites any variables related to the map. */
    fun applyOnVersionRef(version: String): String {
        return when (version) {
            "{oldSlVersion}" -> oldSlVersion
            "{oldMaterialVersion}" -> oldMaterialVersion
            "{oldRoomVersion}" -> oldRoomVersion
            "{newSlVersion}" -> newSlVersion
            "{newMaterialVersion}" -> newMaterialVersion
            "{newArchCoreVersion}" -> newArchCoreVersion
            "{newLifecycleVersion}" -> newLifecycleVersion
            "{newPagingVersion}" -> newPagingVersion
            "{newRoomVersion}" -> newRoomVersion
            "{newEspressoVersion}" -> newEspressoVersion
            "{newTestsVersion}" -> newTestsVersion
            "{newJankTestHelperVersion}" -> newJankTestHelperVersion
            "{newUiAutomatorVersion}" -> newUiAutomatorVersion
            else -> version
        }
    }
}