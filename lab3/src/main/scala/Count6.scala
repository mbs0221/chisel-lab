import chisel3._

class Count6 extends Module {
  val io = IO(new Bundle {
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  res := 0.U // dummy code to make it compile
  val reg = RegInit(0.U(3.W))
  reg := reg + 1.U
  when (reg === 6.U) {
    reg := 0.U
  }
  res := reg

  // ***** your code ends here *****

  io.dout := res
}