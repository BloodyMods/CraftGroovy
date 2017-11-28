package atm.bloodworkxgaming.craftgroovy.wrappers;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistClass;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistConstructor;
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;

@GSLWhitelistClass
@GSLWhitelistConstructor
public class PNBTTagCompound extends AbstractICGWrapper<NBTTagCompound> {
    public PNBTTagCompound(NBTTagCompound internal) {
        super(internal);
    }

    /**
     * Gets a set with the names of the keys in the tag compound.
     */
    @GSLWhitelistMember
    public Set<String> getKeySet() {
        return internal.getKeySet();
    }

    /**
     * Gets the type byte for the tag.
     */
    @GSLWhitelistMember
    public byte getId() {
        return internal.getId();
    }

    @GSLWhitelistMember
    public int getSize() {
        return internal.getSize();
    }

    /**
     * Stores the given tag into the map with the given string key. This is mostly used to store tag lists.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setTag(String key, NBTBase value) {
        internal.setTag(key, value);
    }

    /**
     * Stores a new NBTTagByte with the given byte value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setByte(String key, byte value) {
        internal.setByte(key, value);
    }

    /**
     * Stores a new NBTTagShort with the given short value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setShort(String key, short value) {
        internal.setShort(key, value);
    }

    /**
     * Stores a new NBTTagInt with the given integer value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setInteger(String key, int value) {
        internal.setInteger(key, value);
    }

    /**
     * Stores a new NBTTagLong with the given long value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setLong(String key, long value) {
        internal.setLong(key, value);
    }

    @GSLWhitelistMember
    public void setUniqueId(String key, UUID value) {
        internal.setUniqueId(key, value);
    }

    @Nullable
    @GSLWhitelistMember
    public UUID getUniqueId(String key) {
        return internal.getUniqueId(key);
    }

    @GSLWhitelistMember
    public boolean hasUniqueId(String key) {
        return internal.hasUniqueId(key);
    }

    /**
     * Stores a new NBTTagFloat with the given float value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setFloat(String key, float value) {
        internal.setFloat(key, value);
    }

    /**
     * Stores a new NBTTagDouble with the given double value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setDouble(String key, double value) {
        internal.setDouble(key, value);
    }

    /**
     * Stores a new NBTTagString with the given string value into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setString(String key, String value) {
        internal.setString(key, value);
    }

    /**
     * Stores a new NBTTagByteArray with the given array as data into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setByteArray(String key, byte[] value) {
        internal.setByteArray(key, value);
    }

    /**
     * Stores a new NBTTagIntArray with the given array as data into the map with the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setIntArray(String key, int[] value) {
        internal.setIntArray(key, value);
    }

    /**
     * Stores the given boolean value as a NBTTagByte, storing 1 for true and 0 for false, using the given string key.
     * @param key
     * @param value
     */
    @GSLWhitelistMember
    public void setBoolean(String key, boolean value) {
        internal.setBoolean(key, value);
    }

    /**
     * gets a generic tag with the specified name
     * @param key
     */
    @GSLWhitelistMember
    public NBTBase getTag(String key) {
        return internal.getTag(key);
    }

    /**
     * Gets the ID byte for the given tag key
     * @param key
     */
    @GSLWhitelistMember
    public byte getTagId(String key) {
        return internal.getTagId(key);
    }

    /**
     * Returns whether the given string has been previously stored as a key in the map.
     * @param key
     */
    @GSLWhitelistMember
    public boolean hasKey(String key) {
        return internal.hasKey(key);
    }

    /**
     * Returns whether the given string has been previously stored as a key in this tag compound as a particular type,
     * denoted by a parameter in the form of an ordinal. If the provided ordinal is 99, this method will match tag types
     * representing numbers.
     * @param key
     * @param type
     */
    @GSLWhitelistMember
    public boolean hasKey(String key, int type) {
        return internal.hasKey(key, type);
    }

    /**
     * Retrieves a byte value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public byte getByte(String key) {
        return internal.getByte(key);
    }

    /**
     * Retrieves a short value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public short getShort(String key) {
        return internal.getShort(key);
    }

    /**
     * Retrieves an integer value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public int getInteger(String key) {
        return internal.getInteger(key);
    }

    /**
     * Retrieves a long value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public long getLong(String key) {
        return internal.getLong(key);
    }

    /**
     * Retrieves a float value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public float getFloat(String key) {
        return internal.getFloat(key);
    }

    /**
     * Retrieves a double value using the specified key, or 0 if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public double getDouble(String key) {
        return internal.getDouble(key);
    }

    /**
     * Retrieves a string value using the specified key, or an empty string if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public String getString(String key) {
        return internal.getString(key);
    }

    /**
     * Retrieves a byte array using the specified key, or a zero-length array if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public byte[] getByteArray(String key) {
        return internal.getByteArray(key);
    }

    /**
     * Retrieves an int array using the specified key, or a zero-length array if no such key was stored.
     * @param key
     */
    @GSLWhitelistMember
    public int[] getIntArray(String key) {
        return internal.getIntArray(key);
    }

    /**
     * Retrieves a NBTTagCompound subtag matching the specified key, or a new empty NBTTagCompound if no such key was
     * stored.
     * @param key
     */
    @GSLWhitelistMember
    public NBTTagCompound getCompoundTag(String key) {
        return internal.getCompoundTag(key);
    }

    /**
     * Gets the NBTTagList object with the given name.
     * @param key
     * @param type
     */
    @GSLWhitelistMember
    public NBTTagList getTagList(String key, int type) {
        return internal.getTagList(key, type);
    }

    /**
     * Retrieves a boolean value using the specified key, or false if no such key was stored. This uses the getByte
     * method.
     * @param key
     */
    @GSLWhitelistMember
    public boolean getBoolean(String key) {
        return internal.getBoolean(key);
    }

    /**
     * Remove the specified tag.
     * @param key
     */
    @GSLWhitelistMember
    public void removeTag(String key) {
        internal.removeTag(key);
    }

    /**
     * Return whether this compound has no tags.
     */
    @GSLWhitelistMember
    public boolean hasNoTags() {
        return internal.hasNoTags();
    }

    /**
     * Creates a clone of the tag.
     */
    @GSLWhitelistMember
    public NBTTagCompound copy() {
        return internal.copy();
    }

    /**
     * Merges copies of data contained in {@code other} into this compound tag.
     * @param other
     */
    @GSLWhitelistMember
    public void merge(NBTTagCompound other) {
        internal.merge(other);
    }

    @GSLWhitelistMember
    public static String getTagTypeName(int p_193581_0_) {
        return NBTBase.getTagTypeName(p_193581_0_);
    }
}
