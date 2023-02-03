
public class GroupIdArtifactIdVersionBean {

	/**
	 * group id
	 */
	public final String groupId;

	/**
	 * artifact id
	 */
	public final String artifactId;

	/**
	 * version
	 */
	public final String version;

	public GroupIdArtifactIdVersionBean(String groupId, String artifactId, String version) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		return obj == null ? super.equals(obj) : (obj.getClass().isAssignableFrom(GroupIdArtifactIdVersionBean.class) ? this.groupId.equals(((GroupIdArtifactIdVersionBean)obj).groupId) && this.artifactId.equals(((GroupIdArtifactIdVersionBean)obj).artifactId) && this.version.equals(((GroupIdArtifactIdVersionBean)obj).version) : false);
	}

	public String format(String format) {
		return String.format(format, groupId, artifactId, version);
	}
}
