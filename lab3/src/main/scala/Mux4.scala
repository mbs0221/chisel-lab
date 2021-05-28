import chisel3._

/**
  * Use Mux2 components to build a 4:1 multiplexer
  */

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  // ***** your code starts here *****

  // create a Mux4 component out of Mux2 components
  // and connect the input and output ports.

  // below is dummy code to make this example compile
  io.y := 0.U
  when (io.sel === 0.U) {
    io.y := io.a
  }.elsewhen (io.sel === 1.U) {
    io.y := io.b
  }.elsewhen (io.sel === 2.U) {
    io.y := io.c
  }.elsewhen (io.sel === 3.U) {
    io.y := io.d
  }

  // ***** your code ends here *****
}