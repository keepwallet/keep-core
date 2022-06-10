// swift-tools-version:5.6
import PackageDescription

let package = Package(
    name: "CoreModel",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "CoreModel",
            targets: ["CoreModel"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "CoreModel",
            path: "../../core-model/build/XCFrameworks/debug/CoreModel.xcframework"
        ),
    ]
)
