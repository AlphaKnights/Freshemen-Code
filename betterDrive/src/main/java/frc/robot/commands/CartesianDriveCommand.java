// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class CartesianDriveCommand extends CommandBase {
  /** Creates a new CartesianDrive. */
  private final DriveTrainSubsystem m_DriveTrainSubsystem;
  private final XboxController m_controller;
  
  public CartesianDriveCommand(DriveTrainSubsystem drivetrainsubsystem, XboxController p_controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrainSubsystem = drivetrainsubsystem;
    m_controller = p_controller;
    addRequirements(m_DriveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Logitech Joysticks
    //spaghetti code to reduce execution time
    m_DriveTrainSubsystem.cartesianDrive(
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.forward_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.side_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount),
      // (Math.pow((AccelCurve.m*(joystick.getRawAxis(DriveTrainConstants.rotation_axis))-AccelCurve.sub_amount), AccelCurve.exponent)+AccelCurve.add_amount)
      m_controller.getLeftY()*.8,
      m_controller.getRightX()*-1,
      1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}