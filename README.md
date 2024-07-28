# Smart Home Automation System

This project is a simulation of a Smart Home Automation System. 
It demonstrates the use of various design patterns such as Behavioral, Creational, and Structural patterns. 
The system allows users to add devices, control them, set schedules, and automate actions based on triggers.
### Note
Remember to load your metadata in Eclipse project Directory
## Features

- **Add Devices:** Add lights, thermostats, and door locks.
- **Control Devices:** Turn on/off lights, set temperatures for thermostats, and lock/unlock doors.
- **Scheduling:** Schedule actions for devices.
- **Automation:** Add triggers to automate device actions based on conditions.
- **Status Reporting:** Get status reports of all devices in the system.

## Design Patterns Used

1. **Behavioral Patterns:**
   - Observer Pattern
   - Command Pattern

2. **Creational Patterns:**
   - Factory Pattern
   - Singleton Pattern

3. **Structural Patterns:**
   - Adapter Pattern
   - Decorator Pattern

## Getting Started

### Prerequisites

- Java JDK (11 or higher)
- An IDE such as IntelliJ IDEA, Eclipse, or any preferred IDE

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/smart-home-automation.git
### Usage
Choose an option:
1. Add Device
Enter device ID: 1
Enter device type (light, thermostat, door): light
Enter status (on/off for light, locked/unlocked for door): off
Choose an option:
2. Turn On Device
Enter device ID: 1
Choose an option:
4. Set Schedule
Enter device ID: 1
Enter time (HH:MM): 10:30
Enter command (Turn On/Turn Off): Turn On
Choose an option:
5. Add Trigger
Enter condition for trigger: temperature > 60
Enter action for trigger: turnOff 1
Choose an option:
6. Get Status Report
Choose an option:
7. Run Scheduled Tasks
Choose an option:
8. Check Triggers
9. Exit
