package org.firstinspires.ftc.teamcode.baloney.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.baloney.Baloney;

public class SymmetricBaloney extends Baloney {

    public SymmetricBaloney(LinearOpMode opMode) {
        super(opMode);
    }


    public static int BLUE = 1;
    public static int RED = -1;

    public int color = RED;

    @Override
    public void setPower(double l, double r) {
        super.setPower(r, l);
    }

    @Override
    public void setTurningPower(double power) {
        this.setPower(color*power, -color*power);
    }

    @Override
    public void turn(double degrees) {
        super.turn(color*degrees);
    }

    @Override
    public void setSpinPower(double p) {
        this.spinner.setPower(color*p);
    }

    public void beBlue() {
        this.color = BLUE;
    }
    public void beRed() {
        this.color = RED;
    }

}
