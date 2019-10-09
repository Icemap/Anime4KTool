package com.github.icemap.kernel;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author Icemap
 * @date 2019-10-08 15:43
 */
public class KernelPool {

    private static GenericObjectPool<ImageKernel> pool;

    public KernelPool (int poolSize) {
        if (pool == null) {
            GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
            conf.setMaxTotal(poolSize);
            pool = new GenericObjectPool<>(new PooledImageKernel(), conf);
        }
    }

    public ImageKernel borrowKernel () throws Exception {
        return pool.borrowObject();
    }

    public void returnKernel(ImageKernel kernel) {
        pool.returnObject(kernel);
    }
}
