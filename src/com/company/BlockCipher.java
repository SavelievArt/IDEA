package com.company;

/**
 * Created by savel on 04.11.2017.
 */
public abstract class BlockCipher {

    private int keySize;
    private int blockSize;

    BlockCipher(int keySize, int blockSize) {
        this.keySize = keySize;
        this.blockSize = blockSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    /**
     * Set the key from a block of bytes.
     */
    protected abstract void setKey(byte[] key);

    /**
     * Set the key from a string.
     *
     * @param charKey string key
     */
    protected void setKey(String charKey) {
        setKey(Utils.makeKey(charKey, keySize));
    }

    /**
     * Encrypts / decrypts a 64-bit block of data.
     *
     * @param data   64-bit block of data
     * @param offset start point
     */
    public abstract void crypt(byte[] data, int offset);

    /**
     * Encrypts / decrypts a 64-bit block of data.
     *
     * @param data 64-bit block of data
     */
    public void crypt(byte[] data) {
        crypt(data, 0);
    }
}