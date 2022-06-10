import SwiftUI
import CoreModel

struct ContentView: View {
    
    let coins = [
        Coin.ethereum,
        Coin.binance
    ]
    
	var body: some View {
        List {
            Section(header: Text("Coins")) {
                ForEach(coins, id: \.name) { coin in
                    Text("\(coin.name)")
                }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
