// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExtensionSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.motorConstants;
import edu.wpi.first.wpilibj.Joystick;

/** An example command that uses an example subsystem. */
public class Arm extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExtensionSubsystem m_subsystem;
  private final Joystick m_joystick;

  /**
   * Creates a new Arm.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Arm(ExtensionSubsystem subsystem, Joystick joystick) {
    m_subsystem = subsystem;
    m_joystick = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.motorControl(m_joystick.getRawAxis(motorConstants.joystickAxisThing));
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
