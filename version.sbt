val snapshotSuffix = "-SNAPSHOT"

version in ThisBuild := "0.3.6"  + snapshotSuffix

isSnapshot := version.value.endsWith(snapshotSuffix)
