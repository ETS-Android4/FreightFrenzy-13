package org.firstinspires.ftc.teamcode.baloney.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

import java.net.PortUnreachableException;

@TeleOp(name="Recognize", group="baloney")
public class Recognize extends LinearOpMode {
    private Baloney robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Baloney(this);

        while(opModeIsActive()) {
            telemetry.addData("position of duck", robot.recognize());
            telemetry.update();
        }
    }
}
