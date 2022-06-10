import SwiftUI
import CoreModel
import CoreBlockchain

struct ContentView: View {
    
    let coins = [
        Chain.binance,
        Chain.ethereum,
    ]
    
    let network = TryNetworkQuery()
    
	var body: some View {
        List {
            Section(header: Text("Coins")) {
                ForEach(coins, id: \.name) { coin in
                    Text("\(coin.name)")
                }
            }
            
            Section(header: Text("Network")) {
                Button("Send Request") {
                    sendRequest()
                }
            }
        }
	}
    
    func sendRequest() {
        network.query { result, error in
            if let result = result {
                NSLog("result \(result)")
            } else if let error = error {
                NSLog("error \(error)")
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
