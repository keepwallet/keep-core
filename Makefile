ios-framework:
	./gradlew assembleCoreModelDebugXCFramework
	./gradlew assembleCoreBlockchainDebugXCFramework

ios-framework-release:
	./gradlew assembleCoreModelReleaseXCFramework
	./gradlew assembleCoreBlockchainReleaseXCFramework
	pushd core-model/build/XCFrameworks/release/ && zip -r CoreModel.xcframework.zip CoreModel.xcframework
	pushd core-blockchain/build/XCFrameworks/release/ && zip -r CoreBlockchain.xcframework.zip CoreBlockchain.xcframework

checksum:
	shasum -a 256 core-model/build/XCFrameworks/release/CoreModel.xcframework.zip
	shasum -a 256 core-blockchain/build/XCFrameworks/release/CoreBlockchain.xcframework.zip
