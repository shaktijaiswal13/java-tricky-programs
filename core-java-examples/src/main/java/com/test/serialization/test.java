package com.test.serialization;
import java.io.*;
import java.util.*;

public class test
{
    public static void main (String[] args) throws Exception
    {
        X  x = new X ();
        System.out.println (x + " " + x.cache);

        ByteArrayOutputStream  buffer = new ByteArrayOutputStream ();
        new ObjectOutputStream (buffer).writeObject (x);
        x = (X) new ObjectInputStream (new ByteArrayInputStream (buffer.toByteArray ())).readObject ();
        System.out.println (x + " " + x.cache);
    }

    public static class X implements Serializable
    {
        public final transient Map <Object, Object>  cache = new HashMap <Object, Object> ();
    }
}