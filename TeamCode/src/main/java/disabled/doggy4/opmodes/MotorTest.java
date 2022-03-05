package disabled.doggy4.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="MotorTest", group="testing")
@Disabled
public class MotorTest extends LinearOpMode {
    private DcMotor testing;

    @Override
    public void runOpMode() throws InterruptedException {
        testing = hardwareMap.get(DcMotor.class, "test");
        waitForStart();

        testing.setPower(1.0);
        sleep(2000);
        testing.setPower(0);
    }
}
