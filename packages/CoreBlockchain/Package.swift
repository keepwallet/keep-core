// swift-tools-version:5.6
import PackageDescription

let package = Package(
    name: "CoreBlockchain",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "CoreBlockchain",
            targets: ["CoreBlockchain"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "CoreBlockchain",
            path: "../../core-blockchain/build/XCFrameworks/debug/CoreBlockchain.xcframework"
        ),
    ]
)
