package client;

import io.grpc.stub.StreamObserver;
import rpcstubs.Prime;

public class PrimesObserver  implements StreamObserver<Prime> {

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private boolean isCompleted=false;

    @Override
    public void onNext(Prime prime) {
        System.out.println("more one prime:"+prime.getNumber());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {
        isCompleted=true;
       System.out.println("request completed. number of primes is reached");
    }
}
