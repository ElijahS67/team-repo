package seedu.address.logic.commands;

/**
 * Represents a command that modifies the mod attribute of the
 * person identified.
 */
public abstract class ModCommand extends Command {

    public static final String COMMAND_WORD = "mod";
    // TODO: Add the other mod commands
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Modifies the modules related to a person. "
            + "\n [add] [INDEX] [MODS ...]: Adds the entered mods to the person at the index";
    public static final String MESSAGE_MODS_EMPTY = "Mods cannot be empty!";
}
