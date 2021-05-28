import chisel3._

class Accu extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val setZero = Input(Bool())
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  // res := 0.U // dummy code to make it compile

  val acc = RegInit(0.U(32.W))
  acc := acc + io.din
  when (io.setZero) {
    acc := 0.U
  }

  res := acc

  // ***** your code ends here *****

  io.dout := res
}