package org.firstinspires.ftc.teamcode.baloney.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import disabled.doggy4.Robot;

@TeleOp(name="PIDCalibrate", group="baloney")
@Disabled
public class PIDCalibrate extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Baloney(this);

        waitForStart();
        double p = 0.01, i = 0, d = -0, rp = 0.01, ri = 0, rd = -0;
        while(opModeIsActive()) {

            if (gamepad1.a)
                p += -gamepad1.left_stick_y * 0.5;
            if (gamepad2.a)
                p *= -gamepad2.left_stick_y * 0.2 + 1;
            if (gamepad1.b)
                i += -gamepad1.left_stick_y * 0.5;
            if (gamepad2.b)
                i *= -gamepad2.left_stick_y * 0.2 + 1;
            if (gamepad1.x)
                d += -gamepad1.left_stick_y * 0.5;
            if (gamepad2.x)
                d *= -gamepad2.left_stick_y * 0.2 + 1;
            if (gamepad1.dpad_down)
                rp += -gamepad1.right_stick_y * 0.5;
            if (gamepad2.dpad_down)
                rp *= -gamepad2.right_stick_y * 0.2 + 1;
            if (gamepad1.dpad_right)
                ri += -gamepad1.right_stick_y * 0.5;
            if (gamepad2.dpad_right)
                ri *= -gamepad2.right_stick_y * 0.2 + 1;
            if (gamepad1.dpad_left)
                rd += -gamepad1.right_stick_y * 0.5;
            if (gamepad2.dpad_left)
                rd *= -gamepad2.right_stick_y * 0.2 + 1;

            if (gamepad1.left_stick_button || gamepad2.left_stick_button) {
                telemetry.addData("Status", "Now travelling 10 inches");
                telemetry.update();
                robot.initPID(p, i, d, rp, ri, rd);
                robot.travelPID(10);
            }
            if (gamepad1.right_stick_button || gamepad2.right_stick_button) {
                telemetry.addData("Status", "Now turning 90 degrees");
                telemetry.update();
                robot.initPID(p, i, d, rp, ri, rd);
                robot.turn(90);
            }

            telemetry.addData("p", p);
            telemetry.addData("i", i);
            telemetry.addData("d", d);
            telemetry.addData("rp", rp);
            telemetry.addData("ri", ri);
            telemetry.addData("rd", rd);
            telemetry.update();

            sleep(50);
        }
    }
}
