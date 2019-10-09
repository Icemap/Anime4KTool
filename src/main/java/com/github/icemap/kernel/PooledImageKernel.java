package com.github.icemap.kernel;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author Icemap
 * @date 2019-10-08 15:49
 */
public class PooledImageKernel implements PooledObjectFactory<ImageKernel> {

    @Override
    public PooledObject<ImageKernel> makeObject() throws Exception {
        return new DefaultPooledObject<>(new ImageKernel());
    }

    @Override
    public void destroyObject(PooledObject<ImageKernel> pooledObject) throws Exception {
        if (pooledObject.getObject() != null) {
            pooledObject.deallocate();
        }
    }

    @Override
    public boolean validateObject(PooledObject<ImageKernel> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<ImageKernel> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<ImageKernel> pooledObject) throws Exception {

    }
}
