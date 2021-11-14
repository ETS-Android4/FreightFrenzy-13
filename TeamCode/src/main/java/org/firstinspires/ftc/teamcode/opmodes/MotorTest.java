package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="MotorTest", group="testing")
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
