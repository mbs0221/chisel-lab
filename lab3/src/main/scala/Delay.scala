import chisel3._

class Delay extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  // below is dummy code to make this example compile
  // res := io.din
  val delayReg = RegNext(io.din)
  val delayReg2 = RegNext(delayReg)

  res := delayReg2

  // ***** your code ends here *****

  io.dout := res
}