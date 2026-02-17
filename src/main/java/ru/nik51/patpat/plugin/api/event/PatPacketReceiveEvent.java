package ru.nik51.patpat.plugin.api.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.*;

import org.jetbrains.annotations.NotNull;

/**
 * This event is fired when the server receive pat packet from player
 */
public class PatPacketReceiveEvent extends Event implements Cancellable {

	private static final HandlerList HANDLERS = new HandlerList();
	private boolean cancel;

	private final Player whoPatted;
	private final LivingEntity pattedEntity;

	/**
	 * Event is fired when the server receive pat packet from player.
	 *
	 * @param whoPatted    is player who patted, or null if action was performed by non-player source
	 * @param pattedEntity is living entity that received the patting action
	 */
	public PatPacketReceiveEvent(@NotNull Player whoPatted, @NotNull LivingEntity pattedEntity) {
		this.whoPatted    = whoPatted;
		this.pattedEntity = pattedEntity;
	}

	/**
	 * Returns the player who performed the patting action.
	 *
	 * @return the player who patted
	 */
	@NotNull
	public Player getWhoPatted() {
		return whoPatted;
	}

	/**
	 * Gets the entity that was patted.
	 *
	 * @return the patted living entity
	 */
	@NotNull
	public LivingEntity getPattedEntity() {
		return pattedEntity;
	}

	/**
	 * Checks whether this event is cancelled.
	 *
	 * <p>If the event is cancelled, it should not be processed further.</p>
	 *
	 * @return {@code true} if this event is cancelled, otherwise {@code false}
	 */
	@Override
	public boolean isCancelled() {
		return this.cancel;
	}

	/**
	 * Sets the cancelled state of this event.
	 *
	 * <p>When set to {@code true}, the event is considered cancelled and should
	 * not be processed further. Setting it to {@code false} marks the event
	 * as allowed.</p>
	 *
	 * @param cancel {@code true} to cancel the event, {@code false} to allow it
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}

	/**
	 * Returns the Handler List.
	 *
	 * @return the handler list
	 */
	@Override
	@NotNull
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	/**
	 * Returns the Handler List for paper servers.
	 *
	 * @return the handler list
	 */
	@SuppressWarnings({"unusal", "java:S4144"})
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}