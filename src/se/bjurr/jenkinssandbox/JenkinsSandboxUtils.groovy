package se.bjurr.jenkinssandbox

public class JenkinsSandboxUtils {
  /**
  * Get ip of host machine.
  */
  public static String getHostIp(steps) {
    steps.sh(
      returnStdout: true,
      script: '''ip a | grep /32 | cut -d' ' -f 6| cut -d '/' -f 1 '''
    )
    .trim()
  }
}