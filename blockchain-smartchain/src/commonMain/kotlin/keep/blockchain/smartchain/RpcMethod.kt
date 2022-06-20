package keep.blockchain.smartchain

enum class RpcMethod {
    eth_getTransactionByHash,
    eth_getTransactionReceipt,
    eth_gasPrice,
    eth_feeHistory,
    eth_getBalance,
    eth_blockNumber,
    eth_getBlockByNumber,
    eth_getTransactionCount,
    eth_sendRawTransaction,
    eth_estimateGas,
    eth_call,
    eth_chainId,
    net_version,
    eth_syncing,
}