package rpcstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: contract.proto")
public final class ConfigurationServiceGrpc {

  private ConfigurationServiceGrpc() {}

  public static final String SERVICE_NAME = "baseservice.ConfigurationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rpcstubs.Void,
      rpcstubs.ServerFollower> getGetClusterGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClusterGroup",
      requestType = rpcstubs.Void.class,
      responseType = rpcstubs.ServerFollower.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<rpcstubs.Void,
      rpcstubs.ServerFollower> getGetClusterGroupMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Void, rpcstubs.ServerFollower> getGetClusterGroupMethod;
    if ((getGetClusterGroupMethod = ConfigurationServiceGrpc.getGetClusterGroupMethod) == null) {
      synchronized (ConfigurationServiceGrpc.class) {
        if ((getGetClusterGroupMethod = ConfigurationServiceGrpc.getGetClusterGroupMethod) == null) {
          ConfigurationServiceGrpc.getGetClusterGroupMethod = getGetClusterGroupMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Void, rpcstubs.ServerFollower>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetClusterGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.ServerFollower.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigurationServiceMethodDescriptorSupplier("GetClusterGroup"))
              .build();
        }
      }
    }
    return getGetClusterGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigurationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceStub>() {
        @java.lang.Override
        public ConfigurationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationServiceStub(channel, callOptions);
        }
      };
    return ConfigurationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigurationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceBlockingStub>() {
        @java.lang.Override
        public ConfigurationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationServiceBlockingStub(channel, callOptions);
        }
      };
    return ConfigurationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigurationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationServiceFutureStub>() {
        @java.lang.Override
        public ConfigurationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationServiceFutureStub(channel, callOptions);
        }
      };
    return ConfigurationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ConfigurationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getClusterGroup(rpcstubs.Void request,
        io.grpc.stub.StreamObserver<rpcstubs.ServerFollower> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetClusterGroupMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rpcstubs.Void,
                rpcstubs.ServerFollower>(
                  this, METHODID_GET_CLUSTER_GROUP)))
          .build();
    }
  }

  /**
   */
  public static final class ConfigurationServiceStub extends io.grpc.stub.AbstractAsyncStub<ConfigurationServiceStub> {
    private ConfigurationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getClusterGroup(rpcstubs.Void request,
        io.grpc.stub.StreamObserver<rpcstubs.ServerFollower> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetClusterGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConfigurationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConfigurationServiceBlockingStub> {
    private ConfigurationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<rpcstubs.ServerFollower> getClusterGroup(
        rpcstubs.Void request) {
      return blockingServerStreamingCall(
          getChannel(), getGetClusterGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConfigurationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ConfigurationServiceFutureStub> {
    private ConfigurationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_CLUSTER_GROUP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigurationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigurationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CLUSTER_GROUP:
          serviceImpl.getClusterGroup((rpcstubs.Void) request,
              (io.grpc.stub.StreamObserver<rpcstubs.ServerFollower>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConfigurationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigurationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rpcstubs.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigurationService");
    }
  }

  private static final class ConfigurationServiceFileDescriptorSupplier
      extends ConfigurationServiceBaseDescriptorSupplier {
    ConfigurationServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigurationServiceMethodDescriptorSupplier
      extends ConfigurationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigurationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConfigurationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigurationServiceFileDescriptorSupplier())
              .addMethod(getGetClusterGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
