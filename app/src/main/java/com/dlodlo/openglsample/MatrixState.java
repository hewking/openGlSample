package com.dlodlo.openglsample;

import android.opengl.Matrix;

/**
 * Created by Administrator on 2016/12/16.
 * <p>
 * 联系方式：。。。
 */
public class MatrixState {
    private static float[] mProjMatrix = new float[16];//4x4螔螏螕聵螕聲螕鲁 螕聧螔螁螕聯螔掳螕聯螕聝
    private static float[] mVMatrix = new float[16];//螕聣螕拢螕聫螕卤螔禄螕螉螕聨螔禄螕聳螕聝螔鲁螔鈥曃撀徫撀�9螔虏螕聨螕聤螕陆螔螏螕聵螕聲螕鲁
    private static float[] mMVPMatrix;//螕聴螕
    static float[] mMMatrix=new float[16] ;//螔螏螕聼螕聦螕鈧撀幬撯�曃撀屛撯偗螔螀螕聞螕聮螕聠螔螁螔鈥曃撀愇撀轿撀椢捦何捨幬撀樜撀曃撀�


    public static void setInitStack()//螔禄螕卤螕聢螔鈥樜捖参捖晃捖蔽撯偓螔禄螔禄螔鲁螕螀螕聤螔螌螔螏螕聵螕聲螕鲁
    {
        Matrix.setRotateM(mMMatrix, 0, 0, 1, 0, 0);
    }

    public static void transtate(float x,float y,float z)//螕聣螕篓螕聳螕聝螕聭螕聵xyz螕聳螕鈥樜撀捨撀單捨單掆��
    {
        Matrix.translateM(mMMatrix, 0, x, y, z);
    }

    public static void rotate(float angle,float x,float y,float z)//螕聣螕篓螕聳螕聝螕聢螕聠xyz螕聳螕鈥樜撀椢捦何捨單掆��
    {
        Matrix.rotateM(mMMatrix,0,angle,x,y,z);
    }


    //螕聣螕篓螕聳螕聝螕聣螕拢螕聫螕卤螔禄螕螉
    public static void setCamera
    (
            float cx,	//螕聣螕拢螕聫螕卤螔禄螕螉螕聨螔禄螕聳螕聝x
            float cy,   //螕聣螕拢螕聫螕卤螔禄螕螉螕聨螔禄螕聳螕聝y
            float cz,   //螕聣螕拢螕聫螕卤螔禄螕螉螕聨螔禄螕聳螕聝z
            float tx,   //螕聣螕拢螕聫螕卤螔禄螕螉螕聞螔螐螔卤螕秃螔螀螕拢x
            float ty,   //螕聣螕拢螕聫螕卤螔禄螕螉螕聞螔螐螔卤螕秃螔螀螕拢y
            float tz,   //螕聣螕拢螕聫螕卤螔禄螕螉螕聞螔螐螔卤螕秃螔螀螕拢z
            float upx,  //螕聣螕拢螕聫螕卤螔禄螕螉UP螕聫螕虏螕聛螔螐X螔路螕聳螕聛螔螐
            float upy,  //螕聣螕拢螕聫螕卤螔禄螕螉UP螕聫螕虏螕聛螔螐Y螔路螕聳螕聛螔螐
            float upz   //螕聣螕拢螕聫螕卤螔禄螕螉UP螕聫螕虏螕聛螔螐Z螔路螕聳螕聛螔螐
    )
    {
        Matrix.setLookAtM
                (
                        mVMatrix,
                        0,
                        cx,
                        cy,
                        cz,
                        tx,
                        ty,
                        tz,
                        upx,
                        upy,
                        upz
                );
    }

    //螕聣螕篓螕聳螕聝螕聧螔螆螕聤螕聯螕聧螔螁螕聯螔掳螔虏螕聨螕聤螕陆
    public static void setProject
    (
            float left,		//near螕聝螕娄螔螀螕聞left
            float right,    //near螕聝螕娄螔螀螕聞right
            float bottom,   //near螕聝螕娄螔螀螕聞bottom
            float top,      //near螕聝螕娄螔螀螕聞top
            float near,		//near螕聝螕娄螔螏螕聽螕聙螕芦
            float far       //far螕聝螕娄螔螏螕聽螕聙螕芦
    )
    {
        Matrix.frustumM(mProjMatrix, 0, left, right, bottom, top, near, far);
    }

    //螔禄螕卤螕聢螔鈥樜捨幬撀熚撀屛撯偗螕聨螕鈥曃撀屛撯偗螔螀螕聞螕聴螕聹螔卤螕鈧捖晃捖晃捨幬撀樜撀曃撀�
    public static float[] getFinalMatrix()
    {
        mMVPMatrix=new float[16];
        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, mMMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);
        return mMVPMatrix;
    }

    public static float[] getFinalMatrix(float[] spec)
    {
        mMVPMatrix=new float[16];
        Matrix.multiplyMM(mMVPMatrix, 0, mVMatrix, 0, spec, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjMatrix, 0, mMVPMatrix, 0);
        return mMVPMatrix;
    }
}


