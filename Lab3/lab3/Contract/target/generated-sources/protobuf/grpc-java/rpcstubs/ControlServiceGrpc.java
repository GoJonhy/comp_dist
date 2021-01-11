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
public final class ControlServiceGrpc {

  private ControlServiceGrpc() {}

  public static final String SERVICE_NAME = "baseservice.ControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<rpcstubs.Initial,
      rpcstubs.Void> getEnterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Enter",
      requestType = rpcstubs.Initial.class,
      responseType = rpcstubs.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.Initial,
      rpcstubs.Void> getEnterMethod() {
    io.grpc.MethodDescriptor<rpcstubs.Initial, rpcstubs.Void> getEnterMethod;
    if ((getEnterMethod = ControlServiceGrpc.getEnterMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getEnterMethod = ControlServiceGrpc.getEnterMethod) == null) {
          ControlServiceGrpc.getEnterMethod = getEnterMethod =
              io.grpc.MethodDescriptor.<rpcstubs.Initial, rpcstubs.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Enter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Initial.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Void.getDefaultInstance()))
              .setSchemaDescriptor(new ControlServiceMethodDescriptorSupplier("Enter"))
              .build();
        }
      }
    }
    return getEnterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.WarnMsg,
      rpcstubs.WarnMsg> getWarningMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Warning",
      requestType = rpcstubs.WarnMsg.class,
      responseType = rpcstubs.WarnMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<rpcstubs.WarnMsg,
      rpcstubs.WarnMsg> getWarningMethod() {
    io.grpc.MethodDescriptor<rpcstubs.WarnMsg, rpcstubs.WarnMsg> getWarningMethod;
    if ((getWarningMethod = ControlServiceGrpc.getWarningMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getWarningMethod = ControlServiceGrpc.getWarningMethod) == null) {
          ControlServiceGrpc.getWarningMethod = getWarningMethod =
              io.grpc.MethodDescriptor.<rpcstubs.WarnMsg, rpcstubs.WarnMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Warning"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.WarnMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.WarnMsg.getDefaultInstance()))
              .setSchemaDescriptor(new ControlServiceMethodDescriptorSupplier("Warning"))
              .build();
        }
      }
    }
    return getWarningMethod;
  }

  private static volatile io.grpc.MethodDescriptor<rpcstubs.FinalPoint,
      rpcstubs.Payment> getLeaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Leave",
      requestType = rpcstubs.FinalPoint.class,
      responseType = rpcstubs.Payment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<rpcstubs.FinalPoint,
      rpcstubs.Payment> getLeaveMethod() {
    io.grpc.MethodDescriptor<rpcstubs.FinalPoint, rpcstubs.Payment> getLeaveMethod;
    if ((getLeaveMethod = ControlServiceGrpc.getLeaveMethod) == null) {
      synchronized (ControlServiceGrpc.class) {
        if ((getLeaveMethod = ControlServiceGrpc.getLeaveMethod) == null) {
          ControlServiceGrpc.getLeaveMethod = getLeaveMethod =
              io.grpc.MethodDescriptor.<rpcstubs.FinalPoint, rpcstubs.Payment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Leave"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.FinalPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rpcstubs.Payment.getDefaultInstance()))
              .setSchemaDescriptor(new ControlServiceMethodDescriptorSupplier("Leave"))
              .build();
        }
      }
    }
    return getLeaveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControlServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServiceStub>() {
        @java.lang.Override
        public ControlServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServiceStub(channel, callOptions);
        }
      };
    return ControlServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServiceBlockingStub>() {
        @java.lang.Override
        public ControlServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServiceBlockingStub(channel, callOptions);
        }
      };
    return ControlServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServiceFutureStub>() {
        @java.lang.Override
        public ControlServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServiceFutureStub(channel, callOptions);
        }
      };
    return ControlServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public void enter(rpcstubs.Initial request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterMethod(), responseObserver);
    }

    /**
     * <pre>
     * emissão/receção de eventos
     * </pre>
     */
    public io.grpc.stub.StreamObserver<rpcstubs.WarnMsg> warning(
        io.grpc.stub.StreamObserver<rpcstubs.WarnMsg> responseObserver) {
      return asyncUnimplementedStreamingCall(getWarningMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public void leave(rpcstubs.FinalPoint request,
        io.grpc.stub.StreamObserver<rpcstubs.Payment> responseObserver) {
      asyncUnimplementedUnaryCall(getLeaveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.Initial,
                rpcstubs.Void>(
                  this, METHODID_ENTER)))
          .addMethod(
            getWarningMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                rpcstubs.WarnMsg,
                rpcstubs.WarnMsg>(
                  this, METHODID_WARNING)))
          .addMethod(
            getLeaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rpcstubs.FinalPoint,
                rpcstubs.Payment>(
                  this, METHODID_LEAVE)))
          .build();
    }
  }

  /**
   */
  public static final class ControlServiceStub extends io.grpc.stub.AbstractAsyncStub<ControlServiceStub> {
    private ControlServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public void enter(rpcstubs.Initial request,
        io.grpc.stub.StreamObserver<rpcstubs.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * emissão/receção de eventos
     * </pre>
     */
    public io.grpc.stub.StreamObserver<rpcstubs.WarnMsg> warning(
        io.grpc.stub.StreamObserver<rpcstubs.WarnMsg> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getWarningMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public void leave(rpcstubs.FinalPoint request,
        io.grpc.stub.StreamObserver<rpcstubs.Payment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ControlServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ControlServiceBlockingStub> {
    private ControlServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public rpcstubs.Void enter(rpcstubs.Initial request) {
      return blockingUnaryCall(
          getChannel(), getEnterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public rpcstubs.Payment leave(rpcstubs.FinalPoint request) {
      return blockingUnaryCall(
          getChannel(), getLeaveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ControlServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ControlServiceFutureStub> {
    private ControlServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Entrar na estrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Void> enter(
        rpcstubs.Initial request) {
      return futureUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sair da estrada
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<rpcstubs.Payment> leave(
        rpcstubs.FinalPoint request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENTER = 0;
  private static final int METHODID_LEAVE = 1;
  private static final int METHODID_WARNING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENTER:
          serviceImpl.enter((rpcstubs.Initial) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Void>) responseObserver);
          break;
        case METHODID_LEAVE:
          serviceImpl.leave((rpcstubs.FinalPoint) request,
              (io.grpc.stub.StreamObserver<rpcstubs.Payment>) responseObserver);
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
        case METHODID_WARNING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.warning(
              (io.grpc.stub.StreamObserver<rpcstubs.WarnMsg>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rpcstubs.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControlService");
    }
  }

  private static final class ControlServiceFileDescriptorSupplier
      extends ControlServiceBaseDescriptorSupplier {
    ControlServiceFileDescriptorSupplier() {}
  }

  private static final class ControlServiceMethodDescriptorSupplier
      extends ControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControlServiceFileDescriptorSupplier())
              .addMethod(getEnterMethod())
              .addMethod(getWarningMethod())
              .addMethod(getLeaveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
