package com.msa.devicemanagementwithwi_fi.data.repository


import javax.inject.Inject



class SocketRepositoryIml @Inject constructor(

){

}

//fun SocketRepositoryIml() {
//    try {
//        runBlocking {
//            try {
//                val selectorManager = SelectorManager(Dispatchers.IO)
//                val socket = aSocket(selectorManager).tcp().connect("127.0.0.1", 9002)
//
//
//                val receiveChannel = socket.openReadChannel()
//                val sendChannel = socket.openWriteChannel(autoFlush = true)
//
//                launch(Dispatchers.IO) {
//                    while (true) {
//                        val greeting = receiveChannel.readUTF8Line()
//                        if (greeting != null) {
//                            println(greeting)
//                        } else {
//                            println("Server closed a connection")
//                            socket.close()
//                            selectorManager.close()
//                            exitProcess(0)
//                        }
//                    }
//                }
//
//                while (true) {
//                    val myMessage = readln()
//                    sendChannel.writeStringUtf8("$myMessage\n")
//                }
//            } catch (e: Exception) {
//                println( "main: $e")
//            }
//        }
//    } catch (e: Exception) {
//        println( "main: $e")
//    }
//}